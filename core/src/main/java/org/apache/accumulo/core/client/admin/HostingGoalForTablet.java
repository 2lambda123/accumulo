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
package org.apache.accumulo.core.client.admin;

import java.util.Objects;

import org.apache.accumulo.core.data.TabletId;

/**
 * This class contains information that defines the tablet hosting data for a table. The class
 * contains the TabletId and associated goal for each tablet in a table or a subset of tablets if a
 * range is provided.
 *
 * @since 4.0.0
 */
public class HostingGoalForTablet {
  private final TabletId tabletId;
  private final TabletHostingGoal hostingGoal;

  public HostingGoalForTablet(TabletId tabletId, TabletHostingGoal hostingGoal) {
    this.tabletId = tabletId;
    this.hostingGoal = hostingGoal;
  }

  public TabletHostingGoal getHostingGoal() {
    return hostingGoal;
  }

  public TabletId getTabletId() {
    return tabletId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HostingGoalForTablet that = (HostingGoalForTablet) o;
    return Objects.equals(tabletId, that.tabletId) && hostingGoal == that.hostingGoal;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tabletId, hostingGoal);
  }
}
