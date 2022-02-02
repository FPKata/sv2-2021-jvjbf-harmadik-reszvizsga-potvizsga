package contentfile;

public class Video extends BaseContent
{
    private final int LENGTH_IN_MINUTE;

    public Video(String title, int lengthInMinute) {
        super(title);
        this.LENGTH_IN_MINUTE = lengthInMinute;
    }

    @Override
    public boolean isPremiumContent() {
        return LENGTH_IN_MINUTE > 15;
    }
}
