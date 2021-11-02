package com.example.sba.domain;

public class CelebrityFace {
	private Info info;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public static class Info {
		private Size size;

		public Size getSize() {
			return size;
		}

		public void setSize(Size size) {
			this.size = size;
		}

		public static class Size {
			private int width;
			private int height;

			public int getWidth() {
				return width;
			}

			public void setWidth(int width) {
				this.width = width;
			}

			public int getHeight() {
				return height;
			}

			public void setHeight(int height) {
				this.height = height;
			}
		}

		private int faceCount;

		public int getFaceCount() {
			return faceCount;
		}

		public void setFaceCount(int faceCount) {
			this.faceCount = faceCount;
		}
	}

	Faces[] faces = new Faces[info.faceCount];

	public Faces[] getFaces() {
		return faces;
	}

	public void setFaces(Faces[] faces) {
		this.faces = faces;
	}

	public static class Faces {
		private Celebrity celebrity;

		public Celebrity getCelebrity() {
			return celebrity;
		}

		public void setCelebrity(Celebrity celebrity) {
			this.celebrity = celebrity;
		}

		private static class Celebrity {
			private String value;
			private int confidence;

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public int getConfidence() {
				return confidence;
			}

			public void setConfidence(int confidence) {
				this.confidence = confidence;
			}
		}
	}
}
