package friendsbets.core.aspects.deletepasswords;

import java.util.Collection;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import friendsbets.core.models.Group;
import friendsbets.core.models.User;

@Component
@Aspect
public class DeletePasswordBeanAspect {

//	@AfterReturning(pointcut="@annotation(friendsbets.core.aspects.deletepasswords.DeletePasswords)", returning="usersOrGroups")
//	public <T> void deletePassword(Collection<T> usersOrGroups) throws Throwable {
//		System.out.println("delete password Aspect");
//		if(usersOrGroups.getClass() == User.class)
//			usersOrGroups.stream().forEach(x -> ((User) x).setPassword(null));
//		else if(usersOrGroups.getClass() == Group.class)
//			usersOrGroups.stream()
//				.flatMap(groupsStream -> ((Group)groupsStream).getUserList().stream())
//				.forEach(u -> u.setPassword(null));
//		else
//			throw new Exception();
//	}

//			Set<User> users = usersOrGroups.stream()
//			.flatMap(groupStream -> ((Group) groupStream).getUserList())
//			.map(userStream -> userStream.stream())
//			.collect(Collectors.toSet());
	
	
	@AfterReturning(pointcut="@annotation(friendsbets.core.aspects.deletepasswords.DeletePasswords)", returning="user")
	public void deleteUserPassword(User user) {
		user.setPassword(null);
	}

	@AfterReturning(pointcut="@annotation(friendsbets.core.aspects.deletepasswords.DeletePasswords)", returning="group")
	public void deleteGroupPassword(Group group) {
		group.getUserList().forEach(u -> u.setPassword(null));
	}
	
	@AfterReturning(pointcut="@annotation(friendsbets.core.aspects.deletepasswords.DeletePasswords)", returning="users")
	public void deleteUsersPassword(Collection<User> users) {
		users.forEach(u -> u.setPassword(null));
	}
	
	@AfterReturning(pointcut="@annotation(friendsbets.core.aspects.deletepasswords.DeletePasswords)", returning="groups")
	public void deleteGroupsPassword(Collection<Group> groups) {
		// Méthode 1
		groups.forEach(ul -> ul.getUserList()
				.forEach(u -> u.setPassword(null)));
		// Méthode 2
		groups.stream()
			.flatMap(g -> g.getUserList().stream())
			.forEach(u -> u.setPassword(null));
	}
	
	
}
/* EXEMPLE
package friendsbets.core.sb.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import friendsbets.core.sb.exceptions.DatabaseUnavailableException;
import friendsbets.core.sb.exceptions.FriendsBetsException;
import friendsbets.core.sb.exceptions.JuniorDeveloperException;

@Component
@Aspect
public class ExceptionEncapsulatorAspect {

	private static final Logger logger = Logger.getLogger(ExceptionEncapsulatorAspect.class);

	@Around("@annotation(friendsbets.core.sb.aspects.EncapsulateException)")
	public Object exceptionEncapsulatorAdvice(ProceedingJoinPoint pjp) throws Throwable {
		try {
			return pjp.proceed();
		} catch (JDBCConnectionException ex) {
			return new DatabaseUnavailableException(ex);
		} catch (HibernateException ex) {
			return new JuniorDeveloperException(ex);
		}
	}

	@AfterThrowing(pointcut = "execution(* friendsbets.core.sb.services.*.*(..))", throwing = "e")
	public void nonEncapsulatedExceptionAdvice(Exception e) {
		if (!(e instanceof FriendsBetsException))
			logger.warn("exception " + e.getClass().getName()
					+ "should have been encapsulated in a FriendsBetsException. Please fill a bug.");
	}

}
*/
