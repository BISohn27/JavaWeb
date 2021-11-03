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
	@Autowired
	private APIExamFace face;
	
	public void saveFaceData(String fileName,int mno) {
		String jsonData = face.getCelebrityFaceData(fileName);
		dataProc(jsonData, mno);
	}
	
	public void dataProc(String jsonData,int mno) {
		Gson gson = new Gson();
		Faces[] faces = gson.fromJson(jsonData.substring(jsonData.indexOf("["),jsonData.indexOf("]"+1)), Faces[].class);
		for(Faces facesObj : faces) {
			mapper.putFaceData(mno, facesObj.getCelebrity().getValue(), facesObj.getCelebrity().getConfidence());
		}
	}
}
