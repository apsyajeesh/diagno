//package com.perscholas.service;
//
//
//import com.perscholas.exception.NoteIdMismatchException;
//import com.perscholas.exception.NoteNotFoundException;
//import com.perscholas.persistence.model.User;
//import com.perscholas.persistence.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public Iterable<User> findAll() {
//        return UserRepository.findAll();
//    }
//
//    public User findUser(long id) throws UserNotFoundException {
//        return UserRepository.findById(id)
//                .orElseThrow(UserNotFoundException::new);
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(long id) throws UserNotFoundException {
//        userRepository.findById(id)
//                .orElseThrow(NoteNotFoundException::new);
//        userRepository.deleteById(id);
//    }
//
//
//    public User updateNote(User user, long id) throws UserIdMismatchException, NoteNotFoundException {
//        if (user.getID() != id) {
//            throw new NoteIdMismatchException();
//        }
//        userRepository.findById(id)
//                .orElseThrow(UserNotFoundException::new);
//        return userRepository.save(user);
//    }
//}
