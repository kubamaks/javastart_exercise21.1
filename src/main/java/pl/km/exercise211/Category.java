package pl.km.exercise211;

enum Category {
    GLOCERIES("spozywcze", "Art. spożywcze"),
    HOUSEHOLD("domowe", "Art. gospodarstwa domowego"),
    OTHER("inne", "Inne");

    private final String description;
    private final String tag;

    Category(String tag, String description) {
        this.tag = tag;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public static Category fromTag(String tag) {
        for (Category cat : Category.values()) {
            if (cat.tag.equals(tag)) {
                return cat;
            }
        }
        return null;
    }
}
