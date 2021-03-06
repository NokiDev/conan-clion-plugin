package conan.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import conan.ui.profileMatching.ProfileMatcher;

/**
 * Show the profile matching dialog.
 *
 * Created by Yahav Itzhak on Feb 2018.
 */
public class MatchProfilesAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = getEventProject(anActionEvent);
        if (project == null) {
            return;
        }
        ProfileMatcher.showDialog(project, anActionEvent.getInputEvent().getComponent());
    }
}
