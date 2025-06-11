public class DestinationSorter {

    private class CityNode {
        String cityName;
        ParcelQueue parcelList; // FIFO queue
        CityNode left, right;

        CityNode(String cityName) {
            this.cityName = cityName;
            this.parcelList = new ParcelQueue();
        }
    }

    private CityNode root;

    public DestinationSorter() {
        root = null;
    }

    public void insertParcel(Parcel parcel) {
        root = insertRecursive(root, parcel);
    }

    private CityNode insertRecursive(CityNode node, Parcel parcel) {
        if (node == null) {
            CityNode newNode = new CityNode(parcel.getDestinationCity());
            newNode.parcelList.enqueue(parcel);
            return newNode;
        }

        int cmp = parcel.getDestinationCity().compareToIgnoreCase(node.cityName);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, parcel);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, parcel);
        } else {
            node.parcelList.enqueue(parcel); // same city, add to existing node
        }

        return node;
    }

    public ParcelQueue getCityParcels(String city) {
        CityNode node = findCityNode(root, city);
        return node != null ? node.parcelList : null;
    }

    public void removeParcel(String city, String parcelID) {
        CityNode node = findCityNode(root, city);
        if (node != null && !node.parcelList.isEmpty()) {
            node.parcelList.removeByID(parcelID); // Custom method to remove by ID
        }
    }

    public int countCityParcels(String city) {
        CityNode node = findCityNode(root, city);
        return node != null ? node.parcelList.size() : 0;
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(CityNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println("City: " + node.cityName + " | Parcel Count: " + node.parcelList.size());
            inOrderRecursive(node.right);
        }
    }

    private CityNode findCityNode(CityNode node, String city) {
        if (node == null) return null;

        int cmp = city.compareToIgnoreCase(node.cityName);
        if (cmp < 0) return findCityNode(node.left, city);
        if (cmp > 0) return findCityNode(node.right, city);
        return node;
    }
}
