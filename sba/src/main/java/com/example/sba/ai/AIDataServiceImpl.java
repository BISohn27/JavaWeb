package com.example.sba.ai;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sba.domain.CelebrityFace;
import com.example.sba.domain.CelebrityFace.Faces;
import com.example.sba.domain.Member;
import com.example.sba.mapper.MemberMapper;
import com.google.gson.Gson;

@Service
public class AIDataServiceImpl {
	@Autowired
	private MemberMapper mapper;
	public List<Member> faceData(String fileName) {
		String jsonData = new APIExamFace().getCelebrityFaceData(fileName);
		
		return dataProc(jsonData);
	}
	
	public List<Member> dataProc(String jsonData) {
		Gson gson = new Gson();
		Faces[] faces = gson.fromJson(jsonData.substring(jsonData.indexOf("["),jsonData.indexOf("]"+1)), Faces[].class);
		CelebrityFace cf = gson.fromJson(jsonData, CelebrityFace.class);
		cf.setFaces(faces);
		List<Member> memberList = new ArrayList<>();
		for(Faces facesObj : cf.getFaces()) {
			memberList.add(mapper);
		}
	}
}
