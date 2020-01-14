package com.practice.hackerrank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {
		
			
			//int paramCount = 0;
			StringBuilder querySB = new StringBuilder();
			querySB.append("( ");
			DateFormat df = new SimpleDateFormat("MM-dd-yy HH:mm:ss");
			Date currentDate = new Date();
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(Calendar.MINUTE, -11);
			System.out.println(cal.getTime());
			
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(currentDate);
			startDate.add(Calendar.DATE, -7);
			System.out.println(startDate.getTime());

			querySB.append("submittedDate <= ? 0");
			querySB.append(" AND submittedDate >= ? 1");
			querySB.append(") ");
			
			System.out.println(querySB.toString());
			
			
		}

	}


