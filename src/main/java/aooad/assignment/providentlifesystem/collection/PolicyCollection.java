package aooad.assignment.providentlifesystem.collection;

import aooad.assignment.providentlifesystem.policy.Policy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PolicyCollection {

    private List<Policy> policyList = new ArrayList<>();

    public void add(Policy policy) {
        policyList.add(policy);
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public PolicyIterator getActiveIterator() {
        return new PolicyIterator(this, "Active");
    }

    public PolicyIterator getLapsedIterator() {
        return new PolicyIterator(this, "Lapsed");
    }

    public PolicyIterator getTerminatedIterator() {
        return new PolicyIterator(this, "Terminated");
    }

}
