package com.bazaarvoice.stoplight.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bazaarvoice.stoplight.dao.EmployeeDao;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDao, Long> {
	
	@Query("select distinct eDao.title from EmployeeDao eDao")
	public ArrayList<String> getUniqueTitles();

	@Query("select eDao.title, count(eDao.title) from EmployeeDao eDao group by eDao.title")
	public java.util.List<Object[]> getCountByTitle();
}