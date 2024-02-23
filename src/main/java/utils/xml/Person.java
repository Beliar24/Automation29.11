package utils.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @XmlElement
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "utils.xml.Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
