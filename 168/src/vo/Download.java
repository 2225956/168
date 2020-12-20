package vo;

public class Download {
	
	//下载表数据初始化信息
	private int id;
	private String name;
	private String path;
	private String description;
	private long size;
	private int star;
	private String image;
	private String time;
	private String sizestr;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setSizestr(String sizestr) {
		this.sizestr = sizestr;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
	public String getDescription() {
		return description;
	}
	public long getSize() {
		return size;
	}
	public int getStar() {
		return star;
	}
	public String getImage() {
		return image;
	}
	public String getTime() {
		return time;
	}
	public String getSizestr() {
		return sizestr;
	}
	public Download(int id, String name, String path, String description,
			long size, int star, String image, String time, String sizestr) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.description = description;
		this.size = size;
		this.star = star;
		this.image = image;
		this.time = time;
		this.sizestr = sizestr;
	}
	public Download() {
		super();
	} 
	
	
}
