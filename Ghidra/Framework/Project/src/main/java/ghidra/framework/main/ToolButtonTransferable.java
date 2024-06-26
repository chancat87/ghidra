/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.framework.main;

import java.awt.datatransfer.*;
import java.io.IOException;

import docking.dnd.GenericDataFlavor;
import ghidra.util.Msg;

/**
 * Defines data that is available for drag/drop and clipboard transfers.
 * The data is a ToolButton object.
 */
public class ToolButtonTransferable implements Transferable, ClipboardOwner {

	public static DataFlavor localToolButtonFlavor = createLocalToolButtonFlavor();

	// create a data flavor that is a tool button
	private static DataFlavor createLocalToolButtonFlavor() {
		try {
			return new GenericDataFlavor(
				DataFlavor.javaJVMLocalObjectMimeType + "; class=ghidra.framework.main.ToolButton",
				"Local tool button object");
		}
		catch (Exception e) {
			Msg.showError(ToolButtonTransferable.class, null, null, null, e);
		}
		return null;
	}

	private static DataFlavor[] flavors = { localToolButtonFlavor };
	private ToolButton button;

	/**
	 * Constructor
	 * @param button the button
	 */
	ToolButtonTransferable(ToolButton button) {
		this.button = button;
	}

	@Override
	public synchronized DataFlavor[] getTransferDataFlavors() {
		return flavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor f) {
		return localToolButtonFlavor.equals(f);
	}

	@Override
	public synchronized Object getTransferData(DataFlavor f)
			throws UnsupportedFlavorException, IOException {

		if (f.equals(localToolButtonFlavor)) {
			return button;
		}
		throw new UnsupportedFlavorException(f);

	}

	@Override
	public String toString() {
		return "ToolButtonTransferable";
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// stub
	}

	/**
	 * Clear the tool button that is being transferred.
	 */
	void clearTransferData() {
		button = null;
	}
}
