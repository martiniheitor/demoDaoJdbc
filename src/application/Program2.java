package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentdDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findByid ===");
		Department dep = departmentdDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		List<Department> list = departmentdDao.findAll();
		list = departmentdDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentdDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department update ===");
		Department dep2 = departmentdDao.findById(1);
		dep2.setName("Food");
		departmentdDao.update(dep2);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: Department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentdDao.deleteById(id);
		System.out.println("Delete completed!");

		sc.close();
	}

}