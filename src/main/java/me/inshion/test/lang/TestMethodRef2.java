package me.inshion.test.lang;

import java.util.function.Predicate;

class Student {

	Student(String name) {
		this.name = name;
	}

	String name;

	@Override
	public String toString() {
		return "name:" + this.name;
	}

	String lastName() {
		String[] names = name.split(" ");
		return names[names.length - 1];
	}
}

interface MakeStudent<P extends Student> {

	P make(String name);
}

interface MakeLastname {

	String make();
}

public class TestMethodRef2 {

	public static void main(String[] args) {
		MakeStudent<Student> maker = Student::new;
		Student s1 = maker.make("Xiao Zhang");

		System.out.println(s1 + " - " + s1.lastName());

		MakeLastname s1_laster = s1::lastName;
		String last = s1_laster.make();
		System.out.println(last);
		
		Predicate<String> isEmpty = String::isEmpty;
		boolean ret = isEmpty.test(" ");
		System.out.println(ret);
		
		Predicate<String> isEmpty2 = (s) -> s == null || s.trim().equals("");
		System.out.println(isEmpty2.test(" "));

	}
}
