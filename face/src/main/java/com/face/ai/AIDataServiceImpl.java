package com.face.ai;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.domain.CelebrityFace.Faces;
import com.face.mapper.MemberMapper;
import com.google.gson.Gson;

@Service
public class AIDataServiceImpl {
	@Autowired
	private MemberMapper mapper;
	
	public void saveFaceData(String fileName,int mno) {
		String jsonData = new APIExamFace().getCelebrityFaceData(fileName);
		dataProc(jsonData, mno);
	}
	
	public void dataProc(String jsonData,int mno) {
		Gson gson = new Gson();
		Faces[] faces = gson.fromJson(jsonData.substring(jsonData.indexOf("["),jsonData.indexOf("]")+1), Faces[].class);
		Map<String,Object> map = selectFace(faces);
		
		mapper.putFaceData(mno, (String)map.get("value"), (float)map.get("confidence"));
	}
	
	public Map<String,Object> selectFace(Faces[] faces){
		Map<String,Object> map = new HashMap<>();
		float confidence = 0;
		String value=null;
		
		for(Faces face : faces) {
			if(face.getCelebrity().getConfidence() > confidence) {
				confidence = face.getCelebrity().getConfidence();
				value = face.getCelebrity().getValue();
			}
		}
		
		map.put("value", value);
		map.put("confidence", confidence);
		
		return map;
	}
	
	public Map<String,Object> returnFace(String fileName){
		String jsonData = new APIExamFace().getCelebrityFaceData(fileName);
		Gson gson = new Gson();
		Faces[] faces = gson.fromJson(jsonData.substring(jsonData.indexOf("["),jsonData.indexOf("]")+1), Faces[].class);
		Map<String,Object> map = selectFace(faces);
		
		return map;
	}
}
