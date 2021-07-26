package LeetCode;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author polarisChen
 * @create 2021/7/26 12:43 上午
 */
public class _16_10 {
    public int maxAliveYear(int[] birth, int[] death) {
        Person[] person = new Person[birth.length * 2];
        for (int i = 0; i < birth.length; i++) {
            person[2 * i] = new Person(birth[i], 0);
            person[2 * i + 1] = new Person(death[i], 1);
        }
        Arrays.sort(person);
        int count = 0;
        int max = 0;
        int year = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i].type == 0) {
                count++;
                if (count > max) {
                    max = count;
                    year = person[i].value;
                }

            } else {
                count--;
            }
        }
        return year;
    }

    class Person implements Comparable<Person> {
        int value;
        int type;

        Person(int value, int type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public int compareTo(Person p) {
            if (this.value == p.value) {
                if (this.type == p.type)
                    return 0;
                else if (this.type < p.type)
                    return -1;
                else
                    return 1;
            } else if (this.value > p.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
