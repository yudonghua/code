package ali;

import java.lang.annotation.Annotation;

class User implements BaseIm{
    private int id = 1;
    private String name="aa";
    private String gender;

    public String getGender() {
        return gender;
    }

//    public User(int id, String name){
//        this.id = id;
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int minLength() {
        return 0;
    }
}
