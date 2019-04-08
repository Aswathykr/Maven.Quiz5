package rocks.zipcode.io.quiz4.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author leon on 11/12/2018.
 */
public class ZipCodeWilmington {
    Map<Student, Double> studyMap;

    public ZipCodeWilmington() {
        studyMap = new LinkedHashMap<>();
    }

    public void enroll(Student student) {
        studyMap.put(student, student.getTotalStudyTime());
    }

    public Boolean isEnrolled(Student student) {
        return studyMap.getOrDefault(student, null) != null;
    }

    public void lecture(double numberOfHours) {
        for(Student student : studyMap.keySet()){
           student.learn(numberOfHours);
        }
    }

    public Map<Student, Double> getStudyMap() {
        for(Student student : studyMap.keySet()){
            studyMap.put(student, student.getTotalStudyTime());
        }
        return studyMap;
    }
}
