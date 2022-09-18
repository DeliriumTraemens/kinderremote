package org.nick.kinderremote.service;

import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.util.abstractInheritance.ServiceAbstract;
import org.nick.kinderremote.util.repoServiceUtil.RepoService;
import org.springframework.stereotype.Service;

@Service
public class ProdService extends ServiceAbstract implements RepoService {

    @Override
    public String getAll(HtRequest request) {
        return "It's a ProdReposervice";
    }

    @Override
    public String getById(HtRequest request) {
        return "Prod Service By Id";
    }

    @Override
    public String editHierarchy(HtRequest request) {
        return null;
    }

    @Override
    public String editById(HtRequest request) {
        return null;
    }

    @Override
    public String delete(HtRequest request) {
        return null;
    }

    @Override
    public String createNew(HtRequest request) {
        return null;
    }
}
