
public class Decompression {

	
	
	
	
	int magic = in.readBits(IHuffConstants.BITS_PER_INT);
	
	if(magic != IHuffConstants.B){
		viewer.showError("Error reading compressed file." \n + "File did not start with the huff magic magic number.");
		
		return -1;
		
	}
	
	
}
