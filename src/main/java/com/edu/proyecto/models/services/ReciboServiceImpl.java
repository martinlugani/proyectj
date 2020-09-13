package com.edu.proyecto.models.services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import 	com.opencsv.bean.BeanField;

import  com.opencsv.CSVReader ;
import com.opencsv.CSVReaderHeaderAware;
import  com.opencsv.bean.ColumnPositionMappingStrategy ;
import  com.opencsv.bean.CsvToBean ;
import  com.opencsv.bean.CsvToBeanBuilder ;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.edu.proyecto.models.dao.IReciboDao;
import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.Recibo;
import com.edu.proyecto.models.entity.Usuario;

import org.springframework.stereotype.Service;



@Service
public class ReciboServiceImpl implements IReciboService{
	
	
	@Autowired
	private IReciboDao reciboDao;
	
	
	@Transactional
	public void saveAll(List<Recibo> recibo) {
		// TODO Auto-generated method stub
		reciboDao.saveAll(recibo);

	}
	
	@Transactional
	public void save(Recibo recibo) {
		reciboDao.save(recibo);
		
	}

	@Transactional(readOnly = true)
	public List<Recibo> findAllRec() {
		// TODO Auto-generated method stub
		return (List<Recibo>)reciboDao.findAll();
	 //return (List<Usuario>)usuarioDao.findAll();
	}
	
	@Override
	public Page<Recibo> findAllRec(Pageable pageable) {
		// TODO Auto-generated method stub
		return reciboDao.findAll(pageable);
	}
	
		
}


