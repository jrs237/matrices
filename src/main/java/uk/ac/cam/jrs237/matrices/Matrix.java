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

import java.util.Arrays;

/** An immutable matrix of arbitrary dimensions. */
class Matrix {

  private final double[][] elements;
  private final int width;
  private final int height;

  private Matrix(int height, int width) {
    this(new double[height][width]);
  }

  /** Create a new matrix based on the elements provided. */
  Matrix(double[][] elements) {
    this.elements = elements;
    this.width = elements[0].length;
    this.height = elements.length;
  }

  /** Multiply this matrix by the provided matrix and return the result. */
  Matrix mult(Matrix other) {
    throw new UnsupportedOperationException();
  }

  /** Add this matrix to the provided matrix and return the result. */
  Matrix add(Matrix other) {
    if (width != other.width || height != other.height) {
      throw new IllegalArgumentException("Dimension mismatch");
    }
    Matrix r = new Matrix(height, width);
    for (int col = 0; col < width; col++) {
      for (int row = 0; row < height; row++) {
        r.elements[row][col] = elements[row][col] + other.elements[row][col];
      }
    }
    return r;
  }

  /** Transpose this matrix and return the result. */
  Matrix transpose() {
    throw new UnsupportedOperationException();
  }

  /**
   * Return one element of the matrix.
   *
   * @param row the row of the element
   * @param col the column of the element
   * @return the value of the element
   */
  double get(int row, int col) {
    return elements[row][col];
  }

  int width() {
    return width;
  }

  int height() {
    return height;
  }

  @Override
  public String toString() {
    return Arrays.deepToString(elements);
  }
}
