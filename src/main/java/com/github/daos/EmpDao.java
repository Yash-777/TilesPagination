package com.github.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.github.dtos.EmpDto;

@Repository
public class EmpDao {
	private HibernateTemplate ht;
	private SessionFactory sessions;
	
	/*
	private JdbcTemplate jt;
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}*/
	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	public SessionFactory getSessions() {	return sessions;	}
	public void setSessions(SessionFactory sessions) {	this.sessions = sessions;	}
	
	public void saveEmp(EmpDto edto){
		/*String query ="INSERT INTO `emp`(`name`, `age`, `salary`, `address`) VALUES "+
			"('"+edto.getName()+"','"+edto.getAge()+"','"+edto.getSalary()+"','"+edto.getAddress()+"')";
		System.out.println("Query : "+query);
		jt.update(query);*/
		ht.save(edto);
		
	}
	public void delete(int empid) {
		/* String sql = "DELETE FROM `employee` WHERE empno = '"+empid+"'";
		System.out.println("Delete Query : "+sql);
		jt.update(sql); */

		ht.delete(get(empid));
	}
	
	public List<EmpDto> listEmpoyees(){
		String sql = "FROM emp";
		System.out.println(sql);
		System.out.println(ht);
		
		List<EmpDto> list = ht.loadAll(EmpDto.class);
		return list;
		
		/*List<EmpDto> emplist = jt.query(sql, new RowMapper() {

			public EmpDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpDto emp = new EmpDto();

			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			emp.setSalary(rs.getInt("salary"));
			emp.setAddress(rs.getString("address"));

			System.out.println("***");

			return emp;
			}

		});
		return emplist;*/
		
		/*org.hibernate.Session session = getSessions().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Criteria criteria = session.createCriteria(EmpDto.class);
		List<EmpDto> list = (List<EmpDto>)criteria.list();
		session.getTransaction().commit();
		return list;*/
	}
	/*public List<EmpDto> getAllStudents(int startPageIndex, int recordsPerPage) {
		List<EmpDto> list = new ArrayList<EmpDto>();
		int range = startPageIndex+recordsPerPage;
		String query="SELECT * from (Select M.*, Rownum R From emp M) where r > "+
					startPageIndex +" and r <= "+range;
		System.out.println(query);
		try {
			Session session = getSessions().getCurrentSession();
			session.beginTransaction();
			session.createQuery(query);
			session.getTransaction().commit();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}*/
	
	public EmpDto get(int empId) {
		return ht.get(EmpDto.class, empId);
	}
	public void updateEmp(EmpDto empdto) {
		ht.update(empdto);
	}
	
	public int emp_count(){
		System.out.println("Edao...");
		List<EmpDto> list = ht.loadAll(EmpDto.class);
		int count = list.size();
		System.out.println("Count : "+count);
		return count;
	}
	
	/*public List listByPage(EmpDto edto, int firstResult, int maxResult) {
		String strQry = "from emp c order by c.id desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(strQry);
		query.setFirstResult(10);
		query.setMaxResults(10);

		return query.list();
	}*/
}