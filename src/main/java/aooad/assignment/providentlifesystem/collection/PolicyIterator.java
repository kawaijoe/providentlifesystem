package aooad.assignment.providentlifesystem.collection;

import aooad.assignment.providentlifesystem.policy.Policy;
import aooad.assignment.providentlifesystem.policy.state.*;

import java.util.Iterator;
import java.util.List;


public class PolicyIterator implements Iterator<Policy> {

    private PolicyCollection policyCollection;
    private int position = 0;
    private Policy policy;
    private Class stateToCheck;

    PolicyIterator(PolicyCollection policyCollection, String stateToCheck) {
        this.policyCollection = policyCollection;

        try {
            this.stateToCheck = Class.forName("aooad.assignment.providentlifesystem.policy.state." + stateToCheck);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        List<Policy> policyList = policyCollection.getPolicyList();

        while(position < policyList.size() && !(stateToCheck.isInstance(policyList.get(position).getState()))) {
            position++;
            System.out.println("Loop");
        }

        System.out.println(position);
        policy = policyList.get(position - 1);
        return stateToCheck.isInstance(policy.getState());
    }

    @Override
    public Policy next() {
        return policy;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
