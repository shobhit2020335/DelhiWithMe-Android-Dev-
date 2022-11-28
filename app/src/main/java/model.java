public class model {
    private String img,name;

    public model() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public model(String img, String name) {
        this.img = img;
        this.name = name;
    }
}
