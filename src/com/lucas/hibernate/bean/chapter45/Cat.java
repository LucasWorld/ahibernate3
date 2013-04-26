package com.lucas.hibernate.bean.chapter45;

import java.awt.Color;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
 * ʹ�÷�final���� (��ѡ)
 * ����proxies����Hibernate��һ����Ҫ�Ĺ��ܣ��������������ǣ��־� ��������Ƿ�final�ģ�������ʵ����һ�����з���������Ϊpublic�Ľӿڡ�
 * �������Hibernate�־û�һ��û��ʵ���κνӿڵ�final�࣬������ ����ʹ�ô������ӳٹ������أ������������������Ż���ѡ��
 * ��ҲӦ�ñ����ڷ�final�������� public final�ķ������������ʹ��һ ����public final�������࣬�����ͨ������lazy="false" ����ȷ�ؽ��ô���
 * **/
public class Cat {
	/*
	 * �ṩһ����ʶ���ԣ�identifier property������ѡ�� *
	 */
	private Long id;
	private Date birthdate;
	private Color color;
	private char sex;
	private float weight;
	private int litterId;
	
	private Cat mother;
	private Set kittens = new HashSet();

	/*
	 * ���еĳ־û��඼������һ�� Ĭ�ϵĹ��췽�������Բ���public�ģ��������Ļ�Hibernate�Ϳ���ʹ��
	 * Constructor.newInstance()��ʵ�������ǡ� ����ǿ�ҽ��飬��Hibernate�У�Ϊ�������ڴ�������ɣ����췽��������
	 * ��(package)�ڿɼ��ġ� *
	 */
	public Cat() {
		super();
	}

	/*
	 * Ϊ�־û��ֶ�����������(accessors)���Ƿ�ɱ�ı�־(mutators)(��ѡ)
	 * CatΪ�������г־û��ֶ������˷��ʷ������ܶ�����ORM����ֱ�Ӷ�
	 * ʵ���������г־û����������ţ��ڹ�ϵ���ݿ�schema������ڲ����ݽṹ֮�������Ӳ�
	 * (ԭ��Ϊ"��ֱ��"��indirection)���һЩ��Ĭ�������Hibernate�־û�JavaBeans�������ԣ��Ͽ�
	 * getFoo��isFoo �� setFoo������ʽ�ķ������� �����Ҫ������Զ�ĳЩ�ض�����ʵ��ֱ���ֶη��ʡ�
	 * ���Բ���ҪҪ����Ϊpublic�ġ�Hibernate���Գ־û�һ���� default��protected��private��get/set������
	 * �����Խ��г־û��� *
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getLitterId() {
		return litterId;
	}

	public void setLitterId(int litterId) {
		this.litterId = litterId;
	}

	
	public Cat getMother() {
		return mother;
	}

	public void setMother(Cat mother) {
		this.mother = mother;
	}

	public Set getKittens() {
		return kittens;
	}

	public void setKittens(Set kittens) {
		this.kittens = kittens;
	}

	/*
	 * ʵ��equals()��hashCode() ������������������������ equals() �� hashCode()������
	 * ��ѳ־����ʵ������Set�У�����ʾ��ֵ����ʱ���Ƽ���ô����.�������ѹ�ʵ��.
	 * ʵ��equals()/hashCode()���Զ��׼��ķ����ǱȽ���������
	 * ��ʶ����ֵ�����ֵ��ͬ�������������Ӧ�����ݿ��ͬһ�У������������ȵģ����������ӵ� Set������Set��ֻ��һ��Ԫ�أ���
	 * ���ҵ��ǣ������ɵı�ʶ���� ʹ�����ַ�����Hibernate������Щ�־û�����  ����ʶֵ��һ���´�����ʵ�����������κα�ʶֵ��
	 * ���⣬ ���һ��ʵ��û�б�����(unsaved)����������ǰ����һ��Set�У������������������� ��һ����ʶֵ��
	 * ���equals() �� hashCode()�ǻ��ڱ�ʶֵ ʵ�ֵģ������ϣ�뽫��ı䣬��Υ����Set����Լ��
	 * ����ȥHibernate��վ���Ķ�������� �����ȫ�����ۡ�ע�⣬�ⲻ��Hibernate�����⣬����һ���Java�����ʶ��Java����ȼ۵��������⡣
	 * ���ǽ���ʹ��ҵ���ֵ���(Business key equality)��ʵ��equals() �� hashCode()��
	 * ҵ���ֵ��ȵ���˼�ǣ�equals()���� �����Ƚ��γ�ҵ��������ԣ���������ʵ�������ʶ���ǵ�ʵ������һ����Ȼ�ĺ�ѡ�룩��
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + litterId;
		result = prime * result + sex;
		result = prime * result + Float.floatToIntBits(weight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (litterId != other.litterId)
			return false;
		if (sex != other.sex)
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}

}
