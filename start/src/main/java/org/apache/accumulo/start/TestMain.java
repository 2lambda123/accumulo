/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.accumulo.start;

/**
 * This program tests that the proper exit code is propagated to the shell.
 *
 * $ ./bin/accumulo org.apache.accumulo.start.TestMain $ ./bin/accumulo
 * org.apache.accumulo.start.TestMain badExit $ ./bin/accumulo org.apache.accumulo.start.TestMain
 * throw
 *
 * The last case tests the proper logging of an exception.
 */
public class TestMain {
  public static void main(String[] args) {
    if (args.length > 0) {
      if (args[0].equals("success")) {
        System.exit(0);
      }
      if (args[0].equals("throw")) {
        throw new IllegalStateException("This is an exception");
      }
    }
    System.exit(-1);
  }
}
