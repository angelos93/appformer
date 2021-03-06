/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.guvnor.common.services.project.service;

import java.util.Collection;

import org.guvnor.common.services.project.model.Module;
import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.project.model.WorkspaceProject;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.repositories.Branch;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.bus.server.annotations.Remote;
import org.uberfire.backend.vfs.Path;
import org.uberfire.spaces.Space;

@Remote
public interface WorkspaceProjectService {

    Collection<WorkspaceProject> getAllWorkspaceProjects();

    Collection<WorkspaceProject> getAllWorkspaceProjects(final OrganizationalUnit organizationalUnit);

    Collection<WorkspaceProject> getAllWorkspaceProjectsByName(final OrganizationalUnit organizationalUnit,
                                                               final String name);

    WorkspaceProject newProject(final OrganizationalUnit organizationalUnit,
                                final POM pom);

    WorkspaceProject newProject(final OrganizationalUnit organizationalUnit,
                                final POM pom,
                                final DeploymentMode mode);

    String createFreshProjectName(final OrganizationalUnit organizationalUnit,
                                  final String name);

    WorkspaceProject resolveProject(final Repository repository);

    WorkspaceProject resolveProject(final Space space, final Branch branch);

    WorkspaceProject resolveProject(final Space space, final Module module);

    WorkspaceProject resolveProject(final Path module);

    WorkspaceProject resolveProject(final Space space, final Path module);

    WorkspaceProject resolveProject(final Space space, final String name);

    WorkspaceProject resolveProjectByRepositoryAlias(final Space space, final String repositoryAlias);
}
