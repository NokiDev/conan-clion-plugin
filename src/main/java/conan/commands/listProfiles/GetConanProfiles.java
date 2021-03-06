package conan.commands.listProfiles;

import conan.commands.SyncConanCommand;
import conan.profiles.ConanProfile;

import java.util.List;

/**
 * Get all Conan profiles.
 * Run "conan profile list"
 *
 * Created by Yahav Itzhak on Feb 2018.
 */
public class GetConanProfiles extends SyncConanCommand {

    public GetConanProfiles(List<ConanProfile> profiles) {
        super(null, new GetConanProfilesProcessListener(profiles), "profile", "list");
    }
}
