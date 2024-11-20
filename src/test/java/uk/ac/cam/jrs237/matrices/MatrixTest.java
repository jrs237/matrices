/*
 * Copyright 2024 Andrew Rice <acr31@cam.ac.uk>, J.R. Shovelton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.jrs237.matrices;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixTest {
  @Test
  public void mult_producesCorrectAnswer() {
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2},
              {3, 4},
              {5, 6},
            });
    Matrix b =
        new Matrix(
            new double[][] {
              {7, 8, 9},
              {10, 11, 12},
            });

    Matrix c = a.mult(b);

    assertThat(c.get(0, 0)).isWithin(1E-7).of(27);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(30);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(33);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(61);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(68);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(75);
    assertThat(c.get(2, 0)).isWithin(1E-7).of(95);
    assertThat(c.get(2, 1)).isWithin(1E-7).of(106);
    assertThat(c.get(2, 2)).isWithin(1E-7).of(117);
  }

  @Test(expected = IllegalArgumentException.class)
  public void mult_dimensionHeightMismatch() {
    Matrix a =
      new Matrix(
        new double[][] {
          {1, 2, 3},
          {4, 5, 6}
        });
    Matrix b =
      new Matrix(
        new double[][] {
          {7, 8, 9},
        });

    a.mult(b);
  }

  @Test
  public void add_producesCorrectAnswer() {
    // ARRANGE
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3},
              {4, 5, 6}
            });
    Matrix b =
        new Matrix(
            new double[][] {
              {7, 8, 9},
              {10, 11, 12},
            });

    // ACT
    Matrix c = a.add(b);

    // ASSERT
    assertThat(c.get(0, 0)).isWithin(1E-7).of(8);
    assertThat(c.get(0, 1)).isWithin(1E-7).of(10);
    assertThat(c.get(0, 2)).isWithin(1E-7).of(12);
    assertThat(c.get(1, 0)).isWithin(1E-7).of(14);
    assertThat(c.get(1, 1)).isWithin(1E-7).of(16);
    assertThat(c.get(1, 2)).isWithin(1E-7).of(18);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add_dimensionHeightMismatch() {
    Matrix a =
      new Matrix(
        new double[][] {
          {1, 2, 3},
          {4, 5, 6}
        });
    Matrix b =
      new Matrix(
        new double[][] {
          {7, 8, 9},
        });

    a.add(b);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add_dimensionWidthMismatch() {
    Matrix a =
      new Matrix(
        new double[][] {
          {1, 2},
          {3, 4}
        });
    Matrix b =
      new Matrix(
        new double[][] {
          {5, 6, 7},
          {8, 9, 10},
        });

    a.add(b);
  }

  @Test
  public void transpose_producesCorrectAnswer() {
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3},
              {4, 5, 6}
            });

    Matrix b = a.transpose();

    assertThat(b.get(0, 0)).isWithin(1E-7).of(1);
    assertThat(b.get(0, 1)).isWithin(1E-7).of(4);
    assertThat(b.get(1, 0)).isWithin(1E-7).of(2);
    assertThat(b.get(1, 1)).isWithin(1E-7).of(5);
    assertThat(b.get(2, 0)).isWithin(1E-7).of(3);
    assertThat(b.get(2, 1)).isWithin(1E-7).of(6);
  }

  @Test
  public void dimensionQueries_produceCorrectAnswer() {
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3},
              {4, 5, 6}
            });

    assertThat(a.width()).isEqualTo(3);
    assertThat(a.height()).isEqualTo(2);
  }

  @Test
  public void toString_producesCorrectAnswer() {
    Matrix a =
        new Matrix(
            new double[][] {
              {1, 2, 3},
              {4, 5, 6}
            });

    assertThat(a.toString()).isEqualTo("[[1.0, 2.0, 3.0], [4.0, 5.0, 6.0]]");
  }

  @Test
  public void constructorCopiesArgument() {
    double[][] array = new double[][] {{1, 2}, {3, 4}};
    Matrix a = new Matrix(array);

    array[0][0] = 5;

    assertThat(a.get(0, 0)).isEqualTo(1);
  }
}
