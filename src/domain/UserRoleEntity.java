package domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles",schema="classicmodels")
@NamedQuery(name="UserRoleEntity.findAll", query="SELECT u FROM UserRoleEntity u")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRoleEntityPK id;

	public UserRoleEntity() {
	}

	public UserRoleEntityPK getId() {
		return this.id;
	}

	public void setId(UserRoleEntityPK id) {
		this.id = id;
	}

}