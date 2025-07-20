//package com.example.Easy.Local.Bank.Service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Easy.Local.Bank.DomainModel.Patient;
//import com.example.Easy.Local.Bank.Repository.patientRepo;
//
//@Service
//public class patientService {
//	
//	@Autowired
//	private patientRepo pRepo;
//	
//	// create User
//	public Patient createUser(Patient p)
//	{
//		return pRepo.save(p);
//	}
//	
//	// show user by id
//	public Optional<Patient> showUserByID(Long id)
//	{
//		return pRepo.findById(id);
//	}
//	
//	//  delete user by id
//	public boolean deleteUserById(Long id)
//	{
//		if(id==null)
//		{
//			System.out.print("Id Cannot be null");
//			return false;
//		}
//		else
//		{	
//			if(pRepo.existsById(id))
//			pRepo.deleteById(id);
//			
//			else
//			{
//				System.out.println("Given Id is not present");
//				return false;
//			}
//		}
//		return true;
//	}
//
//}
