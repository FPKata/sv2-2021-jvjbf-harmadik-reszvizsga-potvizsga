package contentfile;

import java.util.List;

public class Podcast extends BaseContent {
    List<String> performers;

    public Podcast(String title, List<String> performers) {
        super(title);
        this.performers = performers;
    }

    @Override
    public boolean isPremiumContent() {
        return false;
    }
}

