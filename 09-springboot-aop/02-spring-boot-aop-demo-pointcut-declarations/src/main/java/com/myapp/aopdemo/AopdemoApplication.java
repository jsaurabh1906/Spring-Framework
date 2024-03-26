package com.myapp.aopdemo;

import com.myapp.aopdemo.dao.AccountDAO;
import com.myapp.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			System.out.println("Hello");
			demoTheBeforeAdvice(accountDAO, membershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		//call the business method
		Account acc1 = new Account();
		acc1.setName("Saurabh");
		acc1.setLevel("Platinum");
		
		accountDAO.addAccount(acc1); //will match on @Before advice

		accountDAO.addAccount(acc1,true);

		accountDAO.doWork();

		//call the account dao getter/setter methods
		accountDAO.setName("jsndjs");
		accountDAO.setServiceCode("ndjfndj");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();


		// call the membership business method
		membershipDAO.addAccount(); //will match on @Before advice

		membershipDAO.addSillyMemberAccount();

		membershipDAO.goToSleep();
	}
}
