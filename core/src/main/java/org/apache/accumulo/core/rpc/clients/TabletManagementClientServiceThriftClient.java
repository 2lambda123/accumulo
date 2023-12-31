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
package org.apache.accumulo.core.rpc.clients;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.clientImpl.ClientContext;
import org.apache.accumulo.core.lock.ServiceLockData.ThriftService;
import org.apache.accumulo.core.tablet.thrift.TabletManagementClientService.Client;
import org.apache.accumulo.core.util.Pair;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client side object that can be used to interact with services that support management operations
 * against tablets. See TabletManagementClientService$Iface for a list of supported operations.
 */
public class TabletManagementClientServiceThriftClient extends ThriftClientTypes<Client>
    implements TServerClient<Client> {

  private static final Logger LOG =
      LoggerFactory.getLogger(TabletManagementClientServiceThriftClient.class);
  private final AtomicBoolean warnedAboutTServersBeingDown = new AtomicBoolean(false);

  public TabletManagementClientServiceThriftClient(String serviceName) {
    super(serviceName, new Client.Factory());
  }

  @Override
  public Pair<String,Client> getThriftServerConnection(ClientContext context,
      boolean preferCachedConnections) throws TTransportException {
    return getThriftServerConnection(LOG, this, context, preferCachedConnections,
        warnedAboutTServersBeingDown, ThriftService.TABLET_MANAGEMENT);
  }

  @Override
  public <R> R execute(ClientContext context, Exec<R,Client> exec)
      throws AccumuloException, AccumuloSecurityException {
    return execute(LOG, context, exec);
  }

  @Override
  public void executeVoid(ClientContext context, ExecVoid<Client> exec)
      throws AccumuloException, AccumuloSecurityException {
    executeVoid(LOG, context, exec);
  }

}
