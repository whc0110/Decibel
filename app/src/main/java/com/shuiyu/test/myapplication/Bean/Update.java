package com.shuiyu.test.myapplication.Bean;

import java.io.Serializable;
import java.util.List;

public class Update implements Serializable{	private static final long serialVersionUID = 1593888247L;	private String version;	private String title;	private String download;	private boolean forceupdate;	private long lowestnum;	private String content;	private long vernum;
	public String getVersion() {		return this.version;	}
	public void setVersion(String version) {		this.version = version;	}
	public String getTitle() {		return this.title;	}
	public void setTitle(String title) {		this.title = title;	}
	public String getDownload() {		return this.download;	}
	public void setDownload(String download) {		this.download = download;	}
	public boolean getForceupdate() {		return this.forceupdate;	}
	public void setForceupdate(boolean forceupdate) {		this.forceupdate = forceupdate;	}
	public long getLowestnum() {		return this.lowestnum;	}
	public void setLowestnum(long lowestnum) {		this.lowestnum = lowestnum;	}
	public String getContent() {		return this.content;	}
	public void setContent(String content) {		this.content = content;	}
	public long getVernum() {		return this.vernum;	}
	public void setVernum(long vernum) {		this.vernum = vernum;	}
	public Update() {}
	public Update(String version, String title, String download, boolean forceupdate, long lowestnum, String content, long vernum){
		super();		this.version = version;		this.title = title;		this.download = download;		this.forceupdate = forceupdate;		this.lowestnum = lowestnum;		this.content = content;		this.vernum = vernum;
	}
	public String toString() {
		return "Update [version = " + version + ", title = " + title + ", download = " + download + ", forceupdate = " + forceupdate + ", lowestnum = " + lowestnum + ", content = " + content + ", vernum = " + vernum + "]";	}
}