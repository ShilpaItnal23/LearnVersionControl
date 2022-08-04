package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.model.Employee;

@RestController
public class RestControllerExample {
	
	@Autowired
	Employee employee;
	
	@GetMapping("/welcome") 
	public ResponseEntity<String> wecomeController(){
		String msg = "Welcome to the world of RestAPI";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

	@GetMapping("/greet")
	public String helloController() {
		String greet = "Good Morning ";
		return greet;
	}

	@GetMapping("/name")
	public ResponseEntity<String> twoMessageController( @RequestParam("name") String name ){
	
		String message = name + " , welcome to the world of RestApi.";
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	
	@GetMapping("/course")
	public ResponseEntity<String> courseTrainer( @RequestParam("cname") String cname, @RequestParam("tname") String tname ){
	
		String message = cname + " is our course name and "+ tname + " is our course trainer. ";
		return new ResponseEntity<>(message,HttpStatus.OK);
	}

	@GetMapping("/emp")
	public ResponseEntity<Employee> usingObject(Employee emp){
		//Employee emp = new Employee();
		emp.setEmpId(102);
		emp.setEmpName("Sai");
		emp.setEmpSal(300000.00);
		
	
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}

}
