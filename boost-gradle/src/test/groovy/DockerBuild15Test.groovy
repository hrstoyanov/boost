/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.gradle.testkit.runner.GradleRunner
import org.junit.BeforeClass
import com.github.dockerjava.core.DockerClientBuilder

public class DockerBuild15Test extends AbstractBoostDockerTest {

    @BeforeClass
    public static void setup() {
        resourceDir = new File("build/resources/test/test-spring-boot")
        testProjectDir = new File(integTestDir, "DockerBuild15Test")
        buildFilename = "docker15Test.gradle"
        libertyImage = OL_SPRING_15_IMAGE
        repository = "localhost:5000/test-image15"
        dockerPort = "9080"

        createDir(testProjectDir)
        createTestProject(testProjectDir, resourceDir, buildFilename)
        dockerFile = new File(testProjectDir, "Dockerfile")
        dockerClient = DockerClientBuilder.getInstance().build()

        result = GradleRunner.create()
            .withProjectDir(testProjectDir)
            .forwardOutput()
            .withArguments("build", "-i", "-s")
            .build()
    }
}