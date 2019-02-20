package com.codeclan.w13d2hw.Components;

import com.codeclan.w13d2hw.Models.File;
import com.codeclan.w13d2hw.Models.Folder;
import com.codeclan.w13d2hw.Models.User;
import com.codeclan.w13d2hw.Repositories.FileRepository;
import com.codeclan.w13d2hw.Repositories.FolderRepository;
import com.codeclan.w13d2hw.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;


    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        User user1 = new User("user1");
        userRepository.save(user1);

        User user2 = new User("user2");
        userRepository.save(user2);

        Folder folder1 = new Folder("folder1", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("folder2", user2);
        folderRepository.save(folder2);

        File file1 = new File("file1", ".txt", 800, folder1);
        fileRepository.save(file1);

        File file2 = new File("file2", ".txt", 700, folder2);
        fileRepository.save(file2);
    }
}
