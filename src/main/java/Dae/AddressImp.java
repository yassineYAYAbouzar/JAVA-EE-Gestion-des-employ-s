package Dae;


import Database.HibernateUtil;
import Entities.Address;
import Entities.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressImp implements GenericDae<Address, Long> {

    @Override
    public Address insertElement(Address address) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
            return address;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return new Address();
    }
    @Override
    public Address getElementById(long id) {
        Transaction transaction = null;
        Address employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Address.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }
    @Override
    public List<Address> selectAllElements() {

        Transaction transaction = null;
        List<Address> employeeList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            employeeList = session.createQuery("from Address").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return  employeeList;
    }
    @Override
    public boolean deleteElement(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.remove(employee);
                return true;
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Address updateElement(Address address) {
        return null;
    }


}
