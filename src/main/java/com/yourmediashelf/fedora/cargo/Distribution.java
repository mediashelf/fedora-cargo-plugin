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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Abstract class representing the contents of the software installer package.
 *
 */
public abstract class Distribution {

    public static final String FEDORA_WAR = "fedora.war";

    public static final String IMAGEMANIP_WAR = "imagemanip.war";

    public static final String SAXON_WAR = "saxon.war";

    public static final String FOP_WAR = "fop.war";

    public static final String DEMO_WAR = "fedora-demo.war";

    public static final String FEDORA_HOME = "fedorahome.zip";

    public static final String KEYSTORE = "keystore";

    public static final String TRUSTSTORE = "truststore";

    public static final String DBSPEC = "DefaultDOManager.dbspec";

    public static final String TOMCAT;

    public static final String JDBC_MYSQL;

    public static final String JDBC_DERBY;

    public static final String JDBC_DERBY_NETWORK;

    public static final String JDBC_POSTGRESQL;

    public static final String TOMCAT_BASENAME;

    public static final String COMMONS_COLLECTIONS;

    public static final String COMMONS_DBCP;

    public static final String COMMONS_POOL;

    private static Properties PROPS;
    static {
        // an up to date install.properties should be provided by the buildfile
        String path = "resources/install.properties";
        InputStream in =
                OptionDefinition.class.getClassLoader().getResourceAsStream(
                        path);
        PROPS = new Properties();
        try {
            PROPS.load(in);
        } catch (Exception e) {
            System.err.println("ERROR: Unable to load required resource: " +
                    path);
            System.exit(1);
        }
        TOMCAT = PROPS.getProperty("install.tomcat");
        JDBC_DERBY = PROPS.getProperty("install.jdbc.derby");
        JDBC_DERBY_NETWORK =
                PROPS.getProperty("install.jdbc.derbynetworkclient");
        JDBC_MYSQL = PROPS.getProperty("install.jdbc.mysql");
        JDBC_POSTGRESQL = PROPS.getProperty("install.jdbc.postgresql");
        TOMCAT_BASENAME = PROPS.getProperty("install.tomcat.basename");
        COMMONS_COLLECTIONS = PROPS.getProperty("install.commons.collections");
        COMMONS_DBCP = PROPS.getProperty("install.commons.dbcp");
        COMMONS_POOL = PROPS.getProperty("install.commons.pool");
    }

    /**
     * Tests whether the distribution contains the resource identified by
     * the provided path.
     *
     * @param path The path to the resource (e.g. /foo/bar)
     * @return true iff the distribution contains the resource
     */
    public abstract boolean contains(String path);

    /**
     * Get the requested resource.
     *
     * @param path path of the requested resource
     * @return the requested resource as an InputStream
     * @throws IOException
     */
    public abstract InputStream get(String path) throws IOException;

    /**
     * Get the URL of the resource identified by the provided path.
     *
     * @param path the path for the requested resource
     * @return a URL for the requested resource or null if not found
     */
    public abstract URL getURL(String path);

}
