package com.matthewcasperson.swarmdemo;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.keycloak.Secured;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * Swarm entry point
 */
public class MyMain {
    public static void main(final String... args) throws Exception {

        // Instantiate the container
        final Container container = new Container();

        // Create one or more deployments
        final WARArchive deployment = ShrinkWrap.create(WARArchive.class);

        deployment.as( Secured.class );

        container.start();
        container.deploy(deployment);
    }
}