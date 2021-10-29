package com.bazaarvoice.stoplight.impl;

import com.bazaarvoice.stoplight.ifc.ITitlesCount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitlesCount implements ITitlesCount{
	
	String title;
	Integer count;

}
