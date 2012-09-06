/**
 * Copyright (C) 2012 MediaShelf <http://www.yourmediashelf.com/>
 *
 * This file is part of fedora-cargo-plugin.
 *
 * fedora-cargo-plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * fedora-cargo-plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with fedora-cargo-plugin.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.yourmediashelf.fedora.cargo;

import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.cargo.container.LocalContainer;


/**
 * 
 * @author Edwin Shin
 * @goal fedora-stop
 * @phase post-integration-test
 */
public class FedoraCargoStopMojo extends FedoraCargoMojo {

    public void doExecute() throws MojoExecutionException {

        getLog().info("executing FedoraCargoStopMojo");

        LocalContainer container = getContainer();
        container.stop();
    }
}
