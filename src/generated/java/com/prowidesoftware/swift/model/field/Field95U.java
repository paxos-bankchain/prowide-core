/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
 package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;


/**
 * <h2>SWIFT MT Field 95U</h2>
 * Model and parser for field 95U of a SWIFT MT message.
 *
 * <h4>Subfields (components) Data types</h4>
 * <ol> 
 * 		<li><code>String</code></li> 
 * 		<li><code>String</code></li> 
 * 		<li><code>String</code></li> 
 * 		<li><code>String</code></li> 
 * </ol>
 *
 * <h4>Structure definition</h4>
 * <ul>
 * 		<li>validation pattern: <code>:4!c//35x[$35x]0-2(***)</code></li>
 * 		<li>parser pattern: <code>:S//S[$S]0-2</code></li>
 * 		<li>components pattern: <code>SSSS</code></li>
 * </ul>
 *		 
 * <p>This class complies with standard release <strong>SRU2017</strong></p>
 * <p>NOTE: this source code has been generated from template</p>
 */
@SuppressWarnings("unused") 
@Generated
public class Field95U extends Field implements Serializable, com.prowidesoftware.swift.model.field.GenericField, com.prowidesoftware.swift.model.field.MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 95U
	 */
    public static final String NAME = "95U";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_95U = "95U";
	public static final String PARSER_PATTERN =":S//S[$S]0-2";
	public static final String COMPONENTS_PATTERN = "SSSS";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Party Name subfield
	 */
	public static final Integer PARTY_NAME = 2;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field95U() {
		super(4);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field95U(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field95U(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "95U")) {
			throw new IllegalArgumentException("cannot create field 95U from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}
	
	/**
	 * Parses the parameter value into the internal components structure.
	 * <br />
	 * Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous component values are overwritten.
	 *
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	@Override
	public void parse(final String value) {
		init(4);
		List<String> lines = SwiftParseUtils.getLines(value);
		if (!lines.isEmpty()) {
			setComponent1(SwiftParseUtils.getTokenFirst(lines.get(0), ":", "//"));
			setComponent2(SwiftParseUtils.getTokenSecond(lines.get(0), "//"));
		}
		SwiftParseUtils.setComponentsFromLines(this, 3, null, 1, lines);
	}
	
	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field95U newInstance(Field95U source) {
		Field95U cp = new Field95U();
		cp.setComponents(new ArrayList<String>(source.getComponents()));
		return cp;
	}
	
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		result.append(":");
		append(result, 1);
		result.append("//");
		append(result, 2);
		appendInLines(result, 3, 4);
		return result.toString();
	}

	/**
	* Create a Tag with this field name and the given value.
	* Shorthand for <code>new Tag(NAME, value)</code>
	* @see #NAME
	* @since 7.5
	*/
	public static Tag tag(final String value) {
		return new Tag(NAME, value);
	}

	/**
	* Create a Tag with this field name and an empty string as value
	* Shorthand for <code>new Tag(NAME, "")</code>
	* @see #NAME
	* @since 7.5
	*/
	public static Tag emptyTag() {
		return new Tag(NAME, "");
	}
	
	/**
	 * Get the component1
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Same as getComponent(1)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2=TargetYear._2018)
	public java.lang.String getComponent1AsString() {
		return getComponent(1);
	}

	/**
	 * Get the Qualifier (component1).
	 * @return the Qualifier from component1
	 */
	public String getQualifier() {
		return getComponent(1);
	}

	/**
	 * Set the component1.
	 * @param component1 the component1 to set
	 */
	public Field95U setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Qualifier (component1).
	 * @param component1 the Qualifier to set
	 */
	public Field95U setQualifier(String component1) {
		setComponent(1, component1);
		return this;
	}
	/**
	 * Get the component2
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Same as getComponent(2)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2=TargetYear._2018)
	public java.lang.String getComponent2AsString() {
		return getComponent(2);
	}

	/**
	 * Get the Party Name (component2).
	 * @return the Party Name from component2
	 */
	public String getPartyNameLine1() {
		return getComponent(2);
	}

	/**
	 * Get the Party Name (component3).
	 * @return the Party Name from component3
	 */
	public String getPartyNameLine2() {
		return getComponent(3);
	}

	/**
	 * Get the Party Name (component4).
	 * @return the Party Name from component4
	 */
	public String getPartyNameLine3() {
		return getComponent(4);
	}

	/**
	 * Get the Party Name as a concatenation of component2 to component4.
	 * @return the Party Name from components
	 */
	public String getPartyName() {
		StringBuilder result = new StringBuilder();
		for (int i = 2 ; i < 5 ; i++) {
			if (StringUtils.isNotBlank(getComponent(i))) {
				if (result.length() > 0) {
					result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
				}
				result.append(StringUtils.trimToEmpty(getComponent(i)));
			}
		}
		return result.toString();
	}

	/**
	 * Set the component2.
	 * @param component2 the component2 to set
	 */
	public Field95U setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the Party Name (component2).
	 * @param component2 the Party Name to set
	 */
	public Field95U setPartyNameLine1(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the Party Name (component3).
	 * @param component3 the Party Name to set
	 */
	public Field95U setPartyNameLine2(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the Party Name (component4).
	 * @param component4 the Party Name to set
	 */
	public Field95U setPartyNameLine3(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the Party Name splitting the parameter lines into components 2 to 4.
	 * @param value the Party Name to set, may contain line ends and each line will be set to its correspondent component attribute
	 */
	public Field95U setPartyName(String value) {
		List<String> lines = SwiftParseUtils.getLines(value);
		SwiftParseUtils.setComponentsFromLines(this, 2, 3, 0, lines);
		return this;
	}
	/**
	 * Get the component3
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Same as getComponent(3)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2=TargetYear._2018)
	public java.lang.String getComponent3AsString() {
		return getComponent(3);
	}

	/**
	 * Set the component3.
	 * @param component3 the component3 to set
	 */
	public Field95U setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	/**
	 * Get the component4
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Same as getComponent(4)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2=TargetYear._2018)
	public java.lang.String getComponent4AsString() {
		return getComponent(4);
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field95U setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}

   /**
    * Given a component number it returns true if the component is optional,
    * regardless of the field being mandatory in a particular message.<br />
    * Being the field's value conformed by a composition of one or several 
    * internal component values, the field may be present in a message with
    * a proper value but with some of its internal components not set.
    *
    * @param component component number, first component of a field is referenced as 1
    * @return true if the component is optional for this field, false otherwise
    */
   @Override
   public boolean isOptional(int component) {   
       if (component == 3) {
           return true;
       }
       if (component == 4) {
           return true;
       }
       return false;
   }

   /**
    * Returns true if the field is a GENERIC FIELD as specified by the standard.
    *
    * @return true if the field is generic, false otherwise
    */
   @Override
   public boolean isGeneric() {   
       return true;
   }

   /**
    * Returns the issuer code (or Data Source Scheme or DSS).
    * The DSS is only present in some generic fields, when present, is equals to component two.
    *
    * @return DSS component value or <code>null</code> if the DSS is not set or not available for this field.
    */
   public String getDSS() {
       return null;
   }

   /**
    * Checks if the issuer code (or Data Source Scheme or DSS) is present.
    *
    * @see #getDSS()
    * @return true if DSS is present, false otherwise.
    */
   public boolean isDSSPresent() {
       return getDSS() != null;
   }

	/**
	 * Component number for the conditional qualifier subfield
	 */
    public static final Integer CONDITIONAL_QUALIFIER = 2;
   
   /**
    * Gets the conditional qualifier.<br />
    * The conditional qualifier is the the component following the DSS of generic fields, being component 2 or 3 depending on the field structure definition.
    *
    * @return for generic fields returns the value of the conditional qualifier or <code>null</code> if not set or not applicable for this kind of field.
    */
   public String getConditionalQualifier() {
       return getComponent(CONDITIONAL_QUALIFIER);
   }
   
   public String parserPattern() {
           return PARSER_PATTERN;
   }

	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field95U.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns the field's components pattern
	 * @return the static value of Field95U.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
	 * Returns the field's validators pattern
	 */
	@Override
	public final String validatorPattern() {
		return ":4!c//35x[$35x]0-2(***)";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field95U get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field95U(t) ;
	}
	
	/**
	 * Get the first instance of Field95U in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field95U get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field95U in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field95U> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field95U from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field95U> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final ArrayList<Field95U> result = new ArrayList<Field95U>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field95U(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns the defined amount of components.<br>
	 * This is not the amount of components present in the field instance, but the total amount of components 
	 * that this field accepts as defined. 
	 * @since 7.7
	 */
	@Override
	public int componentsSize() {
		return 4;
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @see MultiLineField#getLine(int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line) {
		return getLine(line, 0);
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 * 
	 * @see MultiLineField#getLine(int, int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line, int offset) {
		Field95U cp = newInstance(this);
		return getLine(cp, line, null, offset);
	}
	
	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @see MultiLineField#getLines()
	 * @return lines content or empty list if field's value is empty
	 * @since 7.7
	 */
	public List<String> getLines() {
		return SwiftParseUtils.getLines(getValue());
	}

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @see MultiLineField#getLines(int)
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLines(int offset) {
		Field95U cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
	}
	
	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int, int )
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end) {
		return getLinesBetween(start, end, 0);
	}

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int start, int end, int offset)
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end, int offset) {
		Field95U cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}
	

	/**
	 * Returns a localized suitable for showing to humans string of a field component.<br>
	 *
	 * @param component number of the component to display
	 * @param locale optional locale to format date and amounts, if null, the default locale is used
	 * @return formatted component value or null if component number is invalid or not present
	 * @throws IllegalArgumentException if component number is invalid for the field
	 * @since 7.8
	 */
	@Override
	public String getValueDisplay(int component, Locale locale) {
		if (component < 1 || component > 4) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 95U");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//default format (as is)
			return getComponent(2);
		}
		if (component == 3) {
			//default format (as is)
			return getComponent(3);
		}
		if (component == 4) {
			//default format (as is)
			return getComponent(4);
		}
		return null;	
	}
	
	/**
	 * Returns english label for components.
	 * <br />
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	@Override
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<String>();
		result.add("Qualifier");
		result.add("Party Name");
		result.add("Party Name 2");
		result.add("Party Name 3");
		return result;
	}
	

}
