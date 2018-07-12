package conan.commands;

import com.intellij.execution.process.ProcessListener;
import com.intellij.openapi.project.Project;
import com.jetbrains.cidr.cpp.cmake.CMakeRunner;
import conan.profiles.CMakeProfile;
import conan.profiles.ConanProfile;

/**
 * Install conan packages.
 *
 * Run "conan install . if=<cmake-target-dir> -pr=<Conan-profile>"
 * or
 * "conan install . if=<cmake-target-dir> -pr=<Conan-profile> --update"
 *
 * Created by Yahav Itzhak on Feb 2018.
 */
public class Install extends AsyncConanCommand {

    public Install(Project project, CMakeProfile cMakeProfile, ConanProfile conanProfile, boolean update) {
        this(project, (ProcessListener) null, cMakeProfile, conanProfile, update);
    }

    public Install(Project project, ProcessListener processListener, CMakeProfile cMakeProfile, ConanProfile conanProfile, boolean update) {
        super(project, conanProfile, processListener, "install", project.getBasePath(), "-if=" + cMakeProfile.getTargetDir(), "-pr=" + conanProfile.getName());
        if (update) {
            addParameter("--update");
        }
        addParameter("--build=missing");
        addParameter("-s build_type=" + cMakeProfile.getName());//Hoping it's Release/Debug/MinSizeRel/Etc.. 
    }

    //TODO add config to deactivate.
    public Install(Project project, CMakeRunner.Listener listener, CMakeProfile cMakeProfile, ConanProfile conanProfile, boolean update) {
        super(project, conanProfile, listener, "install", project.getBasePath(), "-if=" + cMakeProfile.getTargetDir());
        if (update) {
            addParameter("--update");
        }
        addParameter("--build=missing");
        addParameter("-s build_type=" + cMakeProfile.getName());//Hoping it's Release/Debug/MinSizeRel/Etc.. //Else retrieve the correct cmake profile config used.
    }
}
