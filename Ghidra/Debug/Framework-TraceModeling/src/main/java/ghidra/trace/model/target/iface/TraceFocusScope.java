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
package ghidra.trace.model.target.iface;

import ghidra.trace.model.target.info.TraceObjectInfo;

/**
 * An object having a designated "focus"
 * 
 * <p>
 * Focus is usually communicated via various UI hints, but also semantically implies that actions
 * taken within this scope apply to the focused object. The least confusing option is to implement
 * this at the root, but that need not always be the case.
 * 
 * <p>
 * If this is present, it must be on the root object.
 */
@TraceObjectInfo(
	schemaName = "FocusScope",
	shortName = "focus scope",
	attributes = {
		TraceFocusScope.KEY_FOCUS,
	},
	fixedKeys = {})
public interface TraceFocusScope extends TraceObjectInterface {
	String KEY_FOCUS = "_focus";
}
