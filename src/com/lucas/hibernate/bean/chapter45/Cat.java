package com.lucas.hibernate.bean.chapter45;

import java.awt.Color;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
 * 使用非final的类 (可选)
 * 代理（proxies）是Hibernate的一个重要的功能，它依赖的条件是，持久 化类或者是非final的，或者是实现了一个所有方法都声明为public的接口。
 * 你可以用Hibernate持久化一个没有实现任何接口的final类，但是你 不能使用代理来延迟关联加载，这会限制你进行性能优化的选择。
 * 你也应该避免在非final类中声明 public final的方法。如果你想使用一 个有public final方法的类，你必须通过设置lazy="false" 来明确地禁用代理。
 * **/
public class Cat {
	/*
	 * 提供一个标识属性（identifier property）（可选） *
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
	 * 所有的持久化类都必须有一个 默认的构造方法（可以不是public的），这样的话Hibernate就可以使用
	 * Constructor.newInstance()来实例化它们。 我们强烈建议，在Hibernate中，为了运行期代理的生成，构造方法至少是
	 * 包(package)内可见的。 *
	 */
	public Cat() {
		super();
	}

	/*
	 * 为持久化字段声明访问器(accessors)和是否可变的标志(mutators)(可选)
	 * Cat为它的所有持久化字段声明了访问方法。很多其他ORM工具直接对
	 * 实例变量进行持久化。我们相信，在关系数据库schema和类的内部数据结构之间引入间接层
	 * (原文为"非直接"，indirection)会好一些。默认情况下Hibernate持久化JavaBeans风格的属性，认可
	 * getFoo，isFoo 和 setFoo这种形式的方法名。 如果需要，你可以对某些特定属性实行直接字段访问。
	 * 属性不需要要声明为public的。Hibernate可以持久化一个有 default、protected或private的get/set方法对
	 * 的属性进行持久化。 *
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
	 * 实现equals()和hashCode() 如果你有如下需求，你必须重载 equals() 和 hashCode()方法：
	 * 想把持久类的实例放入Set中（当表示多值关联时，推荐这么做）.想重用脱管实例.
	 * 实现equals()/hashCode()最显而易见的方法是比较两个对象
	 * 标识符的值。如果值相同，则两个对象对应于数据库的同一行，因此它们是相等的（如果都被添加到 Set，则在Set中只有一个元素）。
	 * 不幸的是，对生成的标识不能 使用这种方法。Hibernate仅对那些持久化对象  赋标识值，一个新创建的实例将不会有任何标识值。
	 * 此外， 如果一个实例没有被保存(unsaved)，并且它当前正在一个Set中，保存它将会给这个对象 赋一个标识值。
	 * 如果equals() 和 hashCode()是基于标识值 实现的，则其哈希码将会改变，这违反了Set的契约。
	 * 建议去Hibernate的站点阅读关于这个 问题的全部讨论。注意，这不是Hibernate的问题，而是一般的Java对象标识和Java对象等价的语义问题。
	 * 我们建议使用业务键值相等(Business key equality)来实现equals() 和 hashCode()。
	 * 业务键值相等的意思是，equals()方法 仅仅比较形成业务键的属性，它能在现实世界里标识我们的实例（是一个自然的候选码）。
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
