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

/** A static class for constructing matrices with 2d shapes. */
class Shapes {

  /**
   * Create a new 2x2 matrix which applies a rotation
   *
   * @param degrees to rotate by
   * @return a 2x2 matrix
   */
  static Matrix rotation2d(double degrees) {
    throw new UnsupportedOperationException();
  }

  /** Create a new identity matrix with the specified size. */
  static Matrix identity(int size) {
    double[][] data = new double[size][size];
    for (int i = 0; i < size; i++) {
      data[i][i] = 1;
    }
    return new Matrix(data);
  }

  /**
   * Create a new matrix representing the points on the perimeter of a square centred on (0,0).
   *
   * @param size the length of half an edge i.e. the square will run from -size to size
   * @return a matrix of height 2 with each column representing a point on the square
   */
  static Matrix square(int size) {
    throw new UnsupportedOperationException();
  }

  // No instances
  private Shapes() {}
}
