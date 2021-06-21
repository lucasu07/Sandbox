package com.zup.vehicles.domain.service;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.vehicles.domain.exception.EntityInvalid;
import com.zup.vehicles.domain.model.CarModel;
import com.zup.vehicles.domain.model.UserModel;
import com.zup.vehicles.domain.repository.CarRepository;
import com.zup.vehicles.domain.repository.UserRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private UserRepository userRepository;

	public CarModel register(CarModel carModel) {

		String weekDayActive = WeekDayActive(carModel);
		carModel.setDayOfWeek(weekDayActive);
		carModel.setIsCarActive(IsCarActive(weekDayActive));
		Long userId = carModel.getUserModel().getId();

		try {
			Optional<UserModel> userModel = userRepository.findById(userId);
			carModel.setUserModel(userModel.get());			 	
			return carRepository.save(carModel);	
			
		} catch(NoSuchElementException e) {

			throw new EntityInvalid (String.format("User Non-existent"));
		}

	}


	public List<CarModel> listAllCar() {
		return carRepository.findAll();	
	}


	private String WeekDayActive(CarModel carModel) {

		int lastDigit = carModel.getYear() % 10;
		var parameter = new HashMap<Integer, String>(10); 

		parameter.put(0, "segunda-feira");
		parameter.put(2, "terça-feira");
		parameter.put(4, "quarta-feira");
		parameter.put(6, "quinta-feira");
		parameter.put(8, "sexta-feira");
		parameter.put(1, "segunda-feira");
		parameter.put(3, "terça-feira");
		parameter.put(5, "quarta-feira");
		parameter.put(7, "quinta-feira");
		parameter.put(9, "sexta-feira");

		return parameter.get(lastDigit);
	}


	private Boolean IsCarActive(String weekDayActive) {		

		String weekDay;
		Calendar calendar = Calendar.getInstance();
		weekDay = new DateFormatSymbols(new Locale("pt","BR"))
				.getWeekdays()[calendar.get(Calendar.DAY_OF_WEEK)];

		return weekDay==weekDayActive;
	}


}
