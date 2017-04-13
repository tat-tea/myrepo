package entity;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {

	private Integer empno;
	private String ename;
	private String job;
	private Date hiredate;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public void writeLog() {
		System.out.println("empno:" + empno);
		System.out.println("ename:" + ename);
		System.out.println("job:" + job);
		System.out.println("hiredate::" + hiredate);
	}

}