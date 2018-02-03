package aooad.assignment.providentlifesystem.collection;

import aooad.assignment.providentlifesystem.policy.Policy;

import java.util.Iterator;

public class PolicyIterator implements Iterator<Policy> {

    private int position = 0;
    private Class stateToCheck;
    private PolicyCollection policyCollection;

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
        int temptPosition = position;
        int maxIndex = policyCollection.size() - 1;

        while (temptPosition < maxIndex && !stateMatch(temptPosition)) {
            temptPosition++;
        }

        return temptPosition <= maxIndex && stateMatch(temptPosition);
    }

    @Override
    public Policy next() {
        int maxIndex = policyCollection.size() - 1;

        while(position < maxIndex && !stateMatch(position)) {
            position++;
        }

        return policyCollection.get(position++);
    }

    private boolean stateMatch(int position) {
        return stateToCheck.isInstance(policyCollection.get(position).getState());
    }

}
